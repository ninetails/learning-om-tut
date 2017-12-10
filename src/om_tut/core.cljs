(ns om-tut.core
    (:require [om.core :as om :include-macros true]
              [om.dom :as dom :include-macros true]))

(enable-console-print!)

(println "This text is printed from src/om-tut/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))


; (om/root
;   (fn [data owner]
;     (reify om/IRender
;       (render [_]
;         (dom/div nil
;                  (dom/h1 nil (:text data))
;                  (dom/h3 nil "Edit this and watch it change!")))))
;   app-state
;   {:target (. js/document (getElementById "app"))})

(om/root
  (fn [data owner]
    (om/component (dom/h2 nil (:text data))))
  app-state
  {:target (. js/document (getElementById "app0"))})


(om/root
  (fn [data owner]
    (om/component (dom/h2 nil (:text data))))
  app-state
  {:target (. js/document (getElementById "app1"))})

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
