import '../styles/layout.css';

const Footer = () => {
  return (
    <footer className="footer">
      <div><strong>LicenseGuard</strong> © 2024. All rights reserved.</div>
      <div className="footer-links">
        <a href="#">Help Center</a>
        <a href="#">Documentation</a>
        <a href="#">Contact</a>
      </div>
      <div><span className="green-dot"></span> All Systems Operational</div>
    </footer>
  );
};

export default Footer;
