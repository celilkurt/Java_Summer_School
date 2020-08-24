import React, { Component } from "react";

class ShoppingHeader extends Component {
  render() {
    return (
      <div>
        <h1>{this.props.header}</h1>
        <h2>Total number of elemnts: {this.props.numberOfElements}</h2>
      </div>
    );
  }
}

export default ShoppingHeader;
