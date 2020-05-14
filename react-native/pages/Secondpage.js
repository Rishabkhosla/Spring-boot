import React, { Component } from 'react';
import { StyleSheet, View, ScrollView } from 'react-native';
import { Table, TableWrapper, Row ,Rows} from 'react-native-table-component';


export default class SecondPage extends Component {
  static navigationOptions = {
    title: 'Home_Page',
    //Sets Header text of Status Bar
  };
  constructor(props) {
      super(props);
      this.state = {
      loading: true,
        tableHead: [],
        tableData: []
      }
    }
    componentDidMount(){
    fetch("http://192.168.24.129:8080/all_forms")
    .then(response => response.json())
    .then((responseJson)=> {
      this.setState({
       loading: false,
       tableHead:getHead(responseJson[0]),
       tableData:getData(responseJson)
      })
    })
    .catch(error=>console.log(error)) //to catch the errors if any
    }
    render() {
        const state = this.state;
        return (
          <View style={styles.container}>
            <Table borderStyle={{borderWidth: 2, borderColor: '#c8e1ff'}}>
              <Row data={state.tableHead} style={styles.head} textStyle={styles.text}/>
              <Rows data={state.tableData} textStyle={styles.text}/>
            </Table>
          </View>
        )
      }
    }
  function getData(jsonarr){
      const result = jsonarr.map(y=>Object.values(y));
      return(result);
  }
  function getHead(jsonobj){
      const result = Object.keys(jsonobj);
      return(result);
  }
  const styles = StyleSheet.create({
    container: { flex: 1, padding: 16, paddingTop: 30, backgroundColor: '#fff' },
      head: { height: 40, backgroundColor: '#f1f8ff' },
      text: { margin: 6 },
    dataWrapper: { marginTop: -1 },
    row: { height: 50, backgroundColor: '#E7E6E1' }
  });