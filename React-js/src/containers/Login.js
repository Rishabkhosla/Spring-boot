import React, {Component} from 'react';
import { Redirect } from 'react-router-dom';
export default class Login extends Component{
    constructor(props){
        super(props);
        this.state={
        username:'',
        password:'',
        redirect:false
        };
        this.handleSubmit=this.handleSubmit.bind(this);
        this.handleChange=this.handleChange.bind(this);
    }
    handleChange(event){
        this.setState({
            [event.target.name]:event.target.value
        });
    }
    handleSubmit(event){
    const {username,password}=this.state;
    fetch('/', {
                   method: 'POST',
                   headers: {
                         Accept: 'application/json',
                         'Content-Type': 'application/json'
                         },
                   body: JSON.stringify({
                                         username: username,
                                         passwd: password
                                        })
                })
                .then((response) => {
                                     return response.text();
                                    })
                .then((responseJson) => {
                                      if(responseJson==='"NOT_FOUND"'){
                                      alert("wrong username and password");}
                                      else{
                                      this.setState({redirect:true})
//                                      alert("navigate to home screen");
//                                        return <Redirect to="/About" />
                                      }
                                     })
                .catch((error) => console.error(error));
            event.preventDefault();
    }

    render(){

const { redirect } = this.state;

     if (redirect) {
       return <Redirect to='/HomePage'/>;
     }
        return(

            <div>
                <form onSubmit={this.handleSubmit}>
                    <input
                        type="username"
                        name="username"
                        placeholder="Username"
                        value={this.state.username}
                        onChange={this.handleChange}
                        required
                       />
                    <input
                        type="password"
                        name="password"
                        placeholder="Password"
                        value={this.state.password}
                        onChange={this.handleChange}
                        required
                       />
                        <button type="submit" >Login</button>
                </form>
            </div>
        )
    }
}