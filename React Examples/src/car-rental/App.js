import React from "react";
import Header from "./Header";
import ChooseOptions from "./ChooseOptions";
import MyTable from "./Table";

function App(props) {
  var cars = [
    { year: 1996, model: "Sedan", price: 206000 },
    { year: 1998, model: "Pickup", price: 202300 },
    { year: 2008, model: "SUV", price: 21300 }
  ];

  

  return (
    <div>
      <Header content={{ title: "Rent a Car", info: "Select components are used for collecting user provided information from a list of options." }} />
      <ChooseOptions types={["Sedan", "Pickup", "SUV"]} />
      <MyTable cars = {cars}/>
      <MyTable cars = {cars}/>
      <MyTable cars = {cars}/>
    </div>
  );
}

export default App;
