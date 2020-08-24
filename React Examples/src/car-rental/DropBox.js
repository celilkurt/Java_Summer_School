import React from "react";
import MenuItem from "@material-ui/core/MenuItem";
import Select from "@material-ui/core/Select";

function DropBox(props) {
  let items = props.types.map((item) => {
    return <MenuItem>{item}</MenuItem>;
  });
  let type;

  return (
    <div>
      <h3>Select Type</h3>
      <Select
        labelId="demo-simple-select-label"
        id="demo-simple-select"
        value={type}
        displayEmpty
        inputProps={{ "aria-label": "Without label" }}
      >
        {items}
      </Select>
    </div>
  );
}

export default DropBox;
