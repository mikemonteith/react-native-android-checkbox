# react-native-android-checkbox

A React Native checkbox using the stock android widget

## Installation

#### Install the node package

`npm install --save react-native-android-checkbox`

#### Import the java library from `node_modules/react-native-android-checkbox/android`

*android/settings.gradle*
```
include ':react-native-android-checkbox', ':app'

project(':react-native-android-checkbox').projectDir = new File(settingsDir, '../node_modules/react-native-android-checkbox/android')
```

Add the project to your gradle dependencies

*android/app/build.gradle*
```
apply plugin: 'com.android.application'

android {
  ...
}

dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    compile 'com.android.support:appcompat-v7:23.0.1'
    compile 'com.facebook.react:react-native:+' // From node_modules
    compile project(':react-native-android-checkbox')
}

```

Add the package to your ReactInstanceManager

*MainActivity.java*
```java

//import package (usually, your IDE will do this for you)
import com.mikemonteith.reactnativeandroidcheckbox.CheckboxPackage;

// ...

/**
* A list of packages used by the app. If the app uses additional views
* or modules besides the default ones, add more packages here.
*/
@Override
protected List<ReactPackage> getPackages() {
	return Arrays.<ReactPackage>asList(
		new MainReactPackage(),
		new CheckboxPackage() // <-- add this line
	);
}

// ...
```

## Basic Usage

The checkbox component works in exactly the same way as React.Switch

```js
var React = require('react-native');
var Checkbox = require('react-native-android-checkbox');

var ExampleComponent = React.createClass({
	getInitialState: {
		value: false,
	},

	_onValueChange: function(value){
		this.setState({value});
	},

  render: function(){
    return (
			<Checkbox
				value={this.state.value}
				onValueChange={this._onValueChange}
			/>
    );
  },
});
```
