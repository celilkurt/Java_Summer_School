import React, { Component } from "react";
import ReactDOM from "react-dom";

class CountUp extends Component {
  constructor(props) {
    super(props);
    this.state = { counter: 0 };
  }

  render() {
    return (
      <div>
        <h1>Increment Counter</h1>
        <br />
        {this.state.counter}
      </div>
    );
  }
}

export default CountUp;
