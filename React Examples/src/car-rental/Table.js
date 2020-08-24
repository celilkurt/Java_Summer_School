import React from "react";

import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableRow from "@material-ui/core/TableRow";
import TableHead from "@material-ui/core/TableHead";
import Button from "@material-ui/core/Button";

function Tables(props) {

  
  let rows = props.cars.map((car) => {
    return (<TableRow>
      <TableCell align="left">{car.year}</TableCell>
      <TableCell align="left">{car.model}</TableCell>
      <TableCell align="left">{car.price}</TableCell>
      <TableCell align="center">
        <Button variant="contained" color="primary">
          Buy
        </Button>
      </TableCell>
    </TableRow>);
  });


  return (
    <div>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Year</TableCell>
            <TableCell align="left">Model</TableCell>
            <TableCell align="left">Price</TableCell>
            <TableCell align="center">Button</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
            {rows}
          </TableBody>
      </Table>
    </div>
  );
}

export default Tables;
