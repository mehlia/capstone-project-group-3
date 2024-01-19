import { useState } from "react";
import { Outlet, useNavigate } from "react-router-dom";
import bigLogo from "../assets/bigLogo.png";


const LogInForm = ({updateGlobalUser}) => {

    const navigate = useNavigate();
    const [inputName, setInputName] = useState("");
    const [inputPassword, setInputPassword] = useState("");


    const validateUser = async (inputPassword) => {
        try{
            const response = await fetch(`http://localhost:8080/users/${inputPassword}/find/${inputPassword}`);
            const jsonData = await response.json();

            if(inputName === jsonData.name){
                // setLogInUser --> redirects to the user home
                
                updateGlobalUser(inputPassword)
                navigate("/user-home");
            } else {
                throw new Error("Invalid password entered.") // skips to below error catching
            }

        } catch (error) {
            throw new Error("Invalid user info")
        }
    }

    const newUserName = (event) => {
        setInputName(event.target.value);
    }

    const newUserPassword = (event) => {
        setInputPassword(event.target.value);
    }

    const handleFormSubmit = (event) => {

        event.preventDefault(); // prevents race condition

        if(!inputName || !inputPassword){
            alert("Please provide your username and password below.")
            return;
        } else {
            // Refactor this for later
            validateUser(inputPassword).catch((error) => {
                alert("Incorrect user info");
            });
        }
    }


    return ( 
    <>
    <section className="login-form">
        <Outlet />
        <section className="login-title">
            <h1>WELCOME</h1>
            <img className="big-logo" src={bigLogo} alt="schedulism logo" />

        </section>
        <div className="form-container" >
            <form className="username-form" onSubmit={(event) => handleFormSubmit(event)}>
                <label htmlFor="inputName"></label>
                <input 
                    type="text" 
                    className="login-input"
                    onInput={(event) => newUserName(event)}
                    placeholder="username"
                    value={inputName}
                    id = "inputName"
                />

                <label htmlFor="inputPassword"></label>
                <input 
                    type="password" 
                    className="login-input"
                    onInput={(event) => newUserPassword(event)}
                    placeholder="password"
                    value={inputPassword}
                    id = "inputPassword"
                />

                <input type="submit" className="submit" value={"Log-in"}/>
            </form>
        </div>
    </section>
    <footer className="footer">
                <p> 2024 Madame Papier All Rights Reserved, Otherwise We Will Be Sueing &#174;</p>
            </footer>
    </> );
}

export default LogInForm; 