  
import React, { Component } from 'react' ;
import {  Media } from 'reactstrap';
import axios from 'axios';
import Grid from '@material-ui/core/Grid';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import SideNav from '../SideNav';
import {getUsers} from './UserService';

 class UserList extends Component {


    constructor(props){
        super(props);
        this.state = { users: [],
                      isLoading: true,
                      error:null};
    }

    

    componentDidMount(){
        this.setState({isLoading: true});

        getUsers().then(users => {
          let data = [{}];

          users.map((user,index) => {
            data.push({
              key:user.username,
              username:user.username,
              name:user.name,
              email:user.eamil,
              userPhoto:user.image,
              location:user.location
            });
            return data;
          });

          this.setState((prevState) => ({
            users:users,isLoading:false
          }))
        });
        
    }

    render() {

        const {users, isLoading, error} = this.state;
        
        if(isLoading){
            return <p>Loading...</p>
        }

        var message = " "; 
        if(localStorage.getItem('username') !== null){
          message = "Welcom " + localStorage.getItem('username');
        }
          

        return (
          <div>
            <Grid container spacing={2}>
            <Grid >
            <SideNav/>
            </Grid>
            <Grid>
              <center>
            <h2>{message}</h2>
            </center>
            <TableContainer component={Paper}>
            <Table aria-label="simple table">
              <TableHead>
                <TableRow>
                  <TableCell><h3>Image</h3></TableCell>
                  <TableCell align="right"><h3>Name</h3></TableCell>
                  <TableCell align="right"><h3>Location</h3></TableCell>
                  <TableCell align="right"><h3>Email</h3></TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {this.state.users.map((user) => (
                  <TableRow >
                    <TableCell align="left">
                      <Media left href="#">
                          <Media object src={user.userPhoto} alt="Generic placeholder image" />
                        </Media>
                    </TableCell>
                    <TableCell align="left">{user.name}</TableCell>
                    <TableCell align="left">{user.location}</TableCell>
                    <TableCell align="left">{user.email}</TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>
          </Grid>
          </Grid>
          </div>
        )
    }
}

export default UserList;
