import React from "react";
import ReactDOM from "react-dom";

export default function () {
  setInterval(incrementCounter, 500);
}

let counter = 0;

function incrementCounter() {
  ReactDOM.render(<div>{counter++}</div>, document.getElementById("root"));
}
