import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import ListItem from '@material-ui/core/ListItem';
import Button from '@material-ui/core/Button';
import ListItemText from '@material-ui/core/ListItemText';

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
  },
  appBar: {
    width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: drawerWidth,
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
  },
  drawerPaper: {
    width: drawerWidth,
  },
  // necessary for content to be below app bar
  toolbar: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.default,
    padding: theme.spacing(3),
  },
}));

export default function SideNav() {
  const classes = useStyles();

  return (<Drawer
        className={classes.drawer}
        variant="permanent"
        classes={{
          paper: classes.drawerPaper,
        }}
        anchor="left"
      >
        <div className={classes.toolbar} />
        <Divider />
        <List>
            <ListItem button >
            <Button variant="contained" color="primary" href="http://localhost:3000/user-list">User List
            </Button>
            </ListItem>
        </List>
        <Divider />
        <List>
            <ListItem button >
            <Button variant="contained" color="primary" onClick={() => { localStorage.removeItem('username') }}>Logout</Button>
            </ListItem>
            <ListItem button >
            <Button variant="contained" color="primary" href="http://localhost:3000/">Login
            </Button>
            </ListItem>
        </List>
      </Drawer>
  )
}