import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import LoginComponent from './LoginComponent';
import RegistrationComponent from './RegistrationComponent';
import UserHome from './UserHome';
import LogoutComponent from './LogoutComponent';
import ErrorComponent from './ErrorComponent';
function RentPlayapp() {
    return (
        <div className="RentPlayapp">
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<LoginComponent />} />
                    <Route path='/login' element={<LoginComponent />} />
                    <Route path='/register' element={<RegistrationComponent />} />
                    <Route path='/welcome/:username' element={
                        <UserHome />
                    } />

                    <Route path='/logout' element={
                        <LogoutComponent />
                    } />

                    <Route path='*' element={<ErrorComponent />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}
export default RentPlayapp;