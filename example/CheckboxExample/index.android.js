/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */

import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

import React, {Component} from 'react';

var Checkbox = require('react-native-android-checkbox');

class CheckboxExample extends Component {
  constructor() {
    super();

    this.state = {
      value: true,
    };

    this._onValueChange = (value) => {
      this.setState({value});
    };
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Shake or press menu button for dev menu
        </Text>
        <Text>{this.state.value ? 'On' : 'Off'}</Text>
        <Checkbox
          value={this.state.value}
          onValueChange={this._onValueChange}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('CheckboxExample', () => CheckboxExample);
