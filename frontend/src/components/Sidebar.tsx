import { useState } from 'react';
import { Link } from 'react-router-dom';
import '../styles/layout.css';

const Sidebar = () => {
  const [open, setOpen] = useState(true);

  return (
    <div className={`sidebar ${open ? 'expanded' : 'collapsed'}`}>
      <button className="toggle-btn" onClick={() => setOpen(!open)}>
        {open ? '◀' : '▶'}
      </button>
      <ul>
        <li><Link to="/inventory">📦 {open && 'License Inventory'}</Link></li>
        <li><Link to="/renewals">🗓️ {open && 'Expiry & Renewal'}</Link></li>
        <li><Link to="/license-assignment">👤 {open && 'License Assignment'}</Link></li>
        <li><Link to="/compliance">🛡️ {open && 'Compliance Monitor'}</Link></li>
        <li><Link to="/procurement">🛒 {open && 'Procurement'}</Link></li>
        <li><Link to="/reports">📝 {open && 'Reports & Audit'}</Link></li>
      </ul>
    </div>
  );
};

export default Sidebar;
