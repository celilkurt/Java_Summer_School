import React from "react";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";

function ShoppingApp(props) {
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

function ShoppingList(props) {
  let list = props.content.items.map((item) => {
    return <ShoppingItem item={item} />;
  });

  return (
    <div>
      <ShoppingListTitle title={props.content.title} />
      <List>{list}</List>
    </div>
  );
}

function ShoppingItem(props) {
  return (
    <ListItem>
      <ListItemText primary={props.item} />
    </ListItem>
  );
}

function ShoppingListTitle(props) {
  return (
    <div>
      <h3>{props.title}</h3>
    </div>
  );
}

function ShoppingHeader(props) {
  return (
    <div>
      <h1>{props.header}</h1>
      <h2>Total number of elemnts: {props.numberOfElements}</h2>
    </div>
  );
}

export default ShoppingApp;
