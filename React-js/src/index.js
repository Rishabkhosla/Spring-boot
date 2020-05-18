import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import { Route, Link,Switch,Redirect,BrowserRouter as Router } from 'react-router-dom'
import HomePage from './containers/HomePage'
import Contact from './containers/Contact'
import * as serviceWorker from './serviceWorker';

const routing = (
  <Router>
     <div>
      <Route exact path="/" component={App} />
      <Route path="/HomePage" component={HomePage} />
    </div>
    </Router>

)
ReactDOM.render(routing, document.getElementById('root'));



