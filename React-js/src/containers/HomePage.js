import React,{Component} from 'react';
import ReactDOM from 'react-dom';

import Table from "./Table";


export default class Home extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
                    loading:true,
                     data:[]
                  };
    this.componentDidMount=this.componentDidMount.bind(this);
  }

  componentDidMount() {
     fetch('/all_forms', {
                       method: 'GET'
                    })
                    .then((response) => {
                                         return response.json();
                                        })
                    .then((responseJson) => {
                                            this.setState({data:responseJson,loading:false});
                                         })
                    .catch((error) => console.error(error)); }

  render() {
   if (this.state.loading==true) {
          return <span>Loading...</span>;
      }

  return(
      <div>
      <Table data={this.state.data}/>
      </div>
    )
  }
}