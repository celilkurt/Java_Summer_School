import React from "react";
import Checkbox from "@material-ui/core/Checkbox";
import DropBox from "./DropBox";

function ChooseOptions(props) {
  let key = true;

  return (
    <div>
      <Checkbox checked={key} name="checkedB" color="primary" />
      <DropBox types={props.types} />
      <br />
    </div>
  );
}

export default ChooseOptions;
