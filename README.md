# Deprecation Notice

React Native now has it's own [CheckBox](https://facebook.github.io/react-native/docs/checkbox.html) component as of version 0.49.
This library will continue to exist, but will not receive updates. You should use the native component.

# react-native-android-checkbox

A React Native checkbox using the stock android widget

![Checkbox Example App](./example/screencast.gif)

## Installation

#### Install the npm package

`npm install --save react-native-android-checkbox`

#### Link the android library

`react-native link react-native-android-checkbox`

## Basic Usage

The checkbox component works in exactly the same way as React.Switch

```js
import React from 'react'
import Checkbox from 'react-native-android-checkbox'

class ExampleComponent extends React.Component {
  constructor() {
    super()
    this.state = {
      value: false
    }
  }

  render() {
    return (
      <Checkbox
        value={this.state.value}
        disabled={false}
        onValueChange={(value) => {
          this.setState({ value })
        }}
        tintColor="#C14C4E"
      />
    )
  }
}
```
