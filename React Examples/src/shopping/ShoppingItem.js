import React, { Component } from "react";

class ShoppingItem extends Component {
  render() {
    return <li>{this.props.item}</li>;
  }
}

export default ShoppingItem;
