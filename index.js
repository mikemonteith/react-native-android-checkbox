'use strict';

import React, {Component, PropTypes} from 'react';

import {
  View,
  StyleSheet,
  requireNativeComponent,
} from 'react-native';

class Checkbox extends Component {
  constructor() {
    super();

    this._checkboxComponent = {};

    this._onChange = (event) => {
      this.props.onChange && this.props.onChange(event);
      this.props.onValueChange && this.props.onValueChange(event.nativeEvent.value);

      this._checkboxComponent.setNativeProps({on: this.props.value});
    }
  }
  
  render() {
    return (
      <View style={this.props.style}>
        <CheckboxComponent
          {...this.props}
          style={styles.checkbox}
          ref={(ref) => { this._checkboxComponent = ref; }}
          on={this.props.value}
          onChange={this._onChange}
        />
      </View>
    );
  }
}

Checkbox.propTypes = {
  ...View.propTypes,

  /**
   * is the checkbox checked. Default false
   */
  value: React.PropTypes.bool,
};

Checkbox.defaultProps = {
  value: false,
};

var styles = StyleSheet.create({
  checkbox: {
    height: 32,
    width: 32,
  },
});

var CheckboxComponent = requireNativeComponent('Checkbox', Checkbox, {
  nativeOnly: { onChange: true, on: true }
});

module.exports = Checkbox;
