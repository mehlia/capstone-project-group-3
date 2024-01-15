import { useState } from "react";
import { Outlet, useNavigate } from "react-router-dom";

const LogInForm = () => {

    const navigate = useNavigate();
    const [name, setName] = useState("");
    const [password, setPassword] = useState("");


    const validateUser = async (password) => {
        try{
            const response = await fetch(`http://localhost:8080/users/${password}`);
            const jsonData = await response.json();

            if(name === jsonData.name){
                // setLogInUser
                navigate("/user-home");
            }

        } catch (error) {
            throw new Error("Invalid user info")
        }
    }

    const newUserName = (event) => {
        setName(event.target.value);
    }
    const newUserPassword = (event) => {
        setPassword(event.target.value);
    }

    const handleFormSubmit = (event) => {
        if(!name || !password){
            alert("Please provide your username and password below.")
            return;
        } else {
            validateUser(password).catch((error) => {
                alert("Incorrect user info");
            });
        }

        event.preventDefault();
        const newUser = {
            name: name,
            password: password,
        }

//      resets username and password ( could remove )
        // setName("");
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
                
                <label htmlFor="username">Username: </label>
                <input 
                    type="text" 
                    className="username"
                    onInput={(event) => newUserName(event)}
                    placeholder="insert username"
                    value={name}
                    id = "username"
                />

                <label htmlFor="password-input">Password: </label>
                <input 
                    type="password" 
                    className="password"
                    onInput={(event) => newUserPassword(event)}
                    placeholder="insert password"
                    value={password}
                    id = "password-input"
                />

                <input type="submit" className="submit" value={"Log-in"}/>
            </form>
        </div>
    </section>
    </> );
}

export default LogInForm;