(ns shx-structural-planning-receipt
 (:require [clojure.string :as str]
           [eta-mu.receipt-river.api :as api]
           [eta-mu.receipt-river.domain.receipt :as receipt]
           [eta-mu.receipt-river.shape.edn :as edn]
           ["node:fs" :as fs]
           ["node:child_process" :as child]))
(let [[mode target payload-file] *command-line-args*]
 (if (= mode "append")
  (let [now (.toISOString (js/Date.))
        params (js->clj (js/JSON.parse (.readFileSync fs payload-file "utf8")) :keywordize-keys true)
        payload (receipt/build-payload (assoc params :kind :decision) "octave-commons/shx" now :decision)
        event (api/build-event {:event-id (str (random-uuid)) :recorded-at now
                 :component-manifest {:eta-mu/version "1.1.1"}
                 :command "whole structural and namespace-boundary planning"
                 :producer {:actor "root/issues"} :subject {:repo "octave-commons/shx"}} payload)
        line (edn/format-line event) result (api/validate-line line 1)]
   (when-not (:ok result) (throw (ex-info "Actual owner refused" (select-keys result [:errors]))))
   (.appendFileSync fs target (str line "\n"))
   (println (js/JSON.stringify (clj->js (select-keys result [:ok :source/schema :errors])))))
  (let [text (if (= mode "git")
               (.execFileSync child "git" #js ["show" (str target ":receipts.edn")] #js {:encoding "utf8"})
               (.readFileSync fs target "utf8"))
        lines (str/split-lines text)
        results (mapv (fn [i line] (select-keys (api/validate-line line (inc i)) [:ok :line-number :source/schema :errors])) (range) lines)
        own (last results)]
   (println (js/JSON.stringify (clj->js {:total-lines (count lines) :owned-addition own
           :historical-rows (dec (count lines))
           :historical-refusals (vec (remove :ok (butlast results)))})))
   (when-not (and (:ok own) (= :declared (get-in own [:source/schema :status])))
    (set! (.-exitCode js/process) 1)))))
