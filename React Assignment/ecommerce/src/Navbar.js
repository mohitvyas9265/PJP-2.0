import React from 'react';
import { Button } from './Button';

import './Navbar.css';

function Navbar() {

    return (
        <>
            <nav className='navbar'>
                <div className='navbar-container'>
                   
                        TRVL
            <i class='fab fa-typo3' />
                    <br />
                    <br />
                    <br />
                   
                    <div className='menu-icon'>
                        <i className={ 'fas fa-bars'} />
                    </div>
                    <ul className={'nav-menu'}>
                        <li className='nav-item'>
                            
                                Shop
                        </li>
         
                   
                        <li className='nav-item'>
                            
                                Contact
              
                        </li>
                        <li className='nav-item'>
                            
                                Sign In
              
                        </li>

                        

                                    <br/>
                                    <br/>
                    </ul>
                    { <Button buttonStyle='btn--outline'>SIGN UP</Button>}
                </div>
            </nav>
        </>
    );
}

export default Navbar;