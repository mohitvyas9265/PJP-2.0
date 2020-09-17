import React from 'react';
import './Footer.css';
import { Button } from './Button';


function Footer() {
    return (
        <div className='footer-container'>
           
            <div class='footer-links'>
                <div className='footer-link-wrapper'>
                    <div class='footer-link-items'>
                        <h2>About me</h2>
                        kmvkfvbmbkmkm
                        kfmkfkbmmgfbmm
                        sdvkjkfjvkjdff
                        skfvmkdfkmmfkm
                        ksmvkdfkvdfmmlm
                    </div>
                    <div class='footer-link-items'>
                        <h2>Products</h2>
                        product 1<br/>
                        product 2<br />
                        product 3<br />
                        product 4<br />
                        product 5
                    </div>
                    
                </div>
                <div className='footer-link-wrapper'>
                    <div class='footer-link-items'>
                        <h2>Useful Links</h2>
                        Your Account<br />
                        Become an Affiliate<br />
                        Shipping Rates<br />
                        Help
                        
                    </div>
                    
                </div>
            </div>
            <section class='social-media'>
                <div class='social-media-wrap'>
                    <div class='footer-logo'>
                        
                       
              <i class='fab fa-typo3' />
                        
                    </div>
                    <small class='website-rights'>Mohit Vyas © 2020</small>
                    
                </div>
            </section>
        </div>
    );
}

export default Footer;