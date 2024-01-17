import { useState } from "react";
import { Outlet, useNavigate } from "react-router-dom";

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

//      resets userinputName and password ( could remove )
        // setInputName("");
        // setPassword(""); 

    }


    return ( 
    <>
    <section className="login-form">
        <Outlet />
        <section className="login-title">
            <h1>This is the login form</h1>
        </section>
        <div className="form-container" >
            <form className="username-form" onSubmit={(event) => handleFormSubmit(event)}>
                <label htmlFor="inputName">UserName: </label>
                <input 
                    type="text" 
                    className="login-input"
                    onInput={(event) => newUserName(event)}
                    placeholder="insert username"
                    value={inputName}
                    id = "inputName"
                />

                <label htmlFor="inputPassword">Password: </label>
                <input 
                    type="password" 
                    className="login-input"
                    onInput={(event) => newUserPassword(event)}
                    placeholder="insert password"
                    value={inputPassword}
                    id = "inputPassword"
                />

                <input type="submit" className="submit" value={"Log-in"}/>
            </form>
        </div>
    </section>
    </> );
}

export default LogInForm;