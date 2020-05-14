//This is an example code for Navigator//
import React, { Component } from 'react';
//import react in our code.
import {
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  TextInput,
  Button,
  TouchableHighlight,
  Image,
  Alert
} from 'react-native';
//import all the components we are going to use.

export default class FirstPage extends Component {
  static navigationOptions = {
  title: 'Login Page'

  };

   constructor(props) {
       super(props);
       this.state = {
           Username: "",
           password: "",
           message: null
         };
       }
       handleUsername = text => {
         this.setState({ Username: text });
       };
       handlePassword = text => {
         this.setState({ password: text });
       };



  render() {

  const { navigate } = this.props.navigation;
    return(
       <View style={styles.container}>
          <TextInput
            style={styles.input}
            underlineColorAndroid="transparent"
            placeholder="Username"
            placeholderTextColor="black"
            autoCapitalize="none"
            onChangeText={this.handleUsername}
          />
          <TextInput
            style={styles.input}
            underlineColorAndroid="transparent"
            placeholder="Password"
            placeholderTextColor="black"
            autoCapitalize="none"
            secureTextEntry={true}
            onChangeText={this.handlePassword}
          />
          <TouchableOpacity
            style={styles.submitButton}
            onPress={() => fetch('http://192.168.24.129:8080/', {
                                            method: 'POST',
                                            headers: {
                                              Accept: 'application/json',
                                              'Content-Type': 'application/json'
                                            },
                                            body: JSON.stringify({
                                              username: this.state.Username,
                                              passwd: this.state.password,
                                            })
                                          })

                                        .then((response) => {
                                                 return response.text();
                                                 console.log(this.state.Username);
                                              })
                                           .then((responseJson) => {
                                                                if(responseJson==='"NOT_FOUND"'){
                                                                alert("wrong username and password");}
                                                                else{
                                                                console.log(this.state.password);
                                                                console.log(this.state.Username);
                                                                navigate('SecondPage');;}
                                                             }).catch((error) => console.error(error))


                                          }
          >
            <Text style={styles.submitButtonText}> Submit </Text>
          </TouchableOpacity>
        </View>
      );
  }}
     const styles = StyleSheet.create({
       container: {
         flex: 2,
         justifyContent: "center",
         // alignItems: "center",
         backgroundColor: "#F5FCFF"
       },
       input: {
         margin: 15,
         height: 40,
         borderColor: "black",
         borderWidth: 1
       },
       submitButton: {
         backgroundColor: "black",
         padding: 10,
         margin: 15,
         alignItems: "center",
         height: 40
       },
       submitButtonText: {
         color: "white"
       }
     });