import React, { Component } from "react";
import ShoppingList from "./ShoppingList";
import ShoppingHeader from "./ShoppingHeader";

class ShoppingApp extends Component {

constructor(props){
  super(props);
  this.state = {message: "new Message"};
}

  render() {



    this.state.setState((prevState) => ({
      prevState.message: "new new message"
    }));

    return (
      <div>
        <ShoppingHeader header="Shopping App" numberOfElements="9" />
        <ShoppingList
          content={{ title: "Food", items: ["Apple", "Bread", "Cheese"] }}
        />
        <ShoppingList
          content={{ title: "Clothes", items: ["Shirt", "Pants", "Hat"] }}
        />
        <ShoppingList
          content={{ title: "Supplies", items: ["Pen", "Paper", "Glue"] }}
        />
      </div>
    );
  }
}

export default ShoppingApp;
