import React, { Component } from "react";
import ShoppingListTitle from "./ShoppingListTitle";
import ShoppingItem from "./ShoppingItem";

class ShoppingList extends Component {
  render() {
    let list = this.props.content.items.map((item) => {
      return <ShoppingItem item={item} />;
    });

    return (
      <div>
        <ShoppingListTitle title={this.props.content.title} />
        {list}
      </div>
    );
  }
}

export default ShoppingList;
