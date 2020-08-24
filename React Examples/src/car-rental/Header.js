import React from "react";

function Header(props) {
  return (
    <div>
      <h1>{props.content.title}</h1>
      <h5>{props.content.info}</h5>
    </div>
  );
}

export default Header;
