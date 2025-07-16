import Sidebar from '../components/Sidebar';
import Footer from '../components/Footer';
import { ReactNode } from 'react';
import '../styles/layout.css';

const Layout = ({ children }: { children: ReactNode }) => {
  return (
    <div className="layout-container">
      <Sidebar />
      <div className="main-container">
        <main className="main-content">
          {children}
        </main>
        <Footer />
      </div>
    </div>
  );
};

export default Layout;
