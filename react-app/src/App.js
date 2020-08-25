import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import UserList from './component/user-list/UserList';
import Login from './component/Login';
import './App.css';


class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Login}/>
          <Route path='/Login' exact={true} component={Login}/>
          <Route path='/user-list' exact={true} component={UserList}/>
        </Switch>
      </Router>
    )
  }
}

export default App;
