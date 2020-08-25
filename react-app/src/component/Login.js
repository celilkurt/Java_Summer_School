
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import React, { Component } from 'react' ;
import Button from '@material-ui/core/Button';
import SideNav from './SideNav';


class Login extends Component {

    constructor(props){
        super(props);

        this.state={
        username:'',
        password:'',
        error:null
        }
    }

    handleClick(event){
        
        const {username,password} = this.state;

        if((username === "ali" || username === "veli") && password === "pass"){
            localStorage.setItem('username', this.state.username);
            localStorage.setItem('myData', this.state.password);
            this.props.history.push('/user-list');
        }else{
            this.setState({error:"Invalid Credientals!"});

        }

        
        
    }

    render() {

        var message = "";
        if(this.state.error !== null)
            message = this.state.error;
            
        return (
        <div>
            <container><SideNav/></container>
            <container>
            <center>
            <MuiThemeProvider>
            <div>
            <AppBar
                title="Login"
            />
            <h2>{message}</h2>
            <TextField
                hintText="Enter your Username"
                floatingLabelText="Username"
                onChange = {(event,newValue) => this.setState({username:newValue})}
                />
            <br/>
                <TextField
                type="password"
                hintText="Enter your Password"
                floatingLabelText="Password"
                onChange = {(event,newValue) => this.setState({password:newValue})}
                />
                <br/>
                <RaisedButton label="Submit" primary={true} style={style} onClick={(event) => this.handleClick(event)}/>
            </div>
            </MuiThemeProvider>
            </center>
            </container>
        </div>
        );
    }
}

    const style = {
    margin: 15,
    };

export default Login;
