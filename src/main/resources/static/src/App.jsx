import React from "react";
import ListItem from "./components/ListItem";


export default class App extends React.Component {

    render() {
        return (
            <div style={{padding:'50px'}}>
                <ListItem />
            </div>
        )
    }
}