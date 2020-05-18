import React from 'react';
import ReactDOM from 'react-dom';
import './App.css';
import Login from "./containers/Login";
class App extends React.Component{
render(){
  return (
    <div className="centered">
     <h1>Login_Page</h1>
     // <Login/>
    </div>
  );
}}

ReactDOM.render(<Login/>, document.getElementById('root'));
export default App;