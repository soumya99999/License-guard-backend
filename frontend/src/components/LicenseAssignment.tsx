import React, { useEffect, useState } from 'react';
import './LicenseAssignment.css';

type AssignmentDTO = {
  assignmentId?: number;
  licenseId: number;
  assignee: string;
  userCount: number;
  assignmentDate: string;
  status: string;
  email: string;
};

const API_URL = 'http://localhost:8080/api/assignments'; // Adjust this if needed

const LicenseAssignment = () => {
  const [form, setForm] = useState<AssignmentDTO>({
    licenseId: 0,
    assignee: '',
    userCount: 1,
    assignmentDate: '',
    status: 'Active',
    email: ''
  });

  const [assignments, setAssignments] = useState<AssignmentDTO[]>([]);

  // useEffect(() => {
  //   fetchAssignments();
  // }, []);
  useEffect(() => {
  // fetchAssignments(); // ← Comment this
  setAssignments([
    {
      assignmentId: 1,
      licenseId: 1,
      assignee: "Amrit Raj",
      userCount: 2,
      assignmentDate: "2025-07-01",
      status: "Active",
      email: "amrit@iem.edu.in"
    },
    {
      assignmentId: 2,
      licenseId: 2,
      assignee: "Shruti Sharma",
      userCount: 1,
      assignmentDate: "2025-06-20",
      status: "Expired",
      email: "shruti@abc.com"
    },
    {
      assignmentId: 3,
      licenseId: 3,
      assignee: "Ravi Kumar",
      userCount: 5,
      assignmentDate: "2025-05-15",
      status: "Revoked",
      email: "ravi.kumar@org.com"
    }
  ]);
}, []);


  // const fetchAssignments = async () => {
  //   try {
  //     const res = await fetch(API_URL);
  //     const data = await res.json();
  //     setAssignments(data);
  //   } catch (error) {
  //     console.error('Failed to fetch assignments', error);
  //   }
  // };

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    const { name, value } = e.target;
    setForm((prev) => ({
      ...prev,
      [name]: name === 'userCount' || name === 'licenseId' ? Number(value) : value,
    }));
  };

  const handleAssign = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const res = await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(form),
      });
      if (res.ok) {
        const newAssignment = await res.json();
        setAssignments([newAssignment, ...assignments]);
        setForm({
          licenseId: 0,
          assignee: '',
          userCount: 1,
          assignmentDate: '',
          status: 'Active',
          email: ''
        });
      } else {
        console.error('Failed to assign license');
      }
    } catch (error) {
      console.error('Error assigning license:', error);
    }
  };

  const handleUnassign = async (id?: number) => {
    if (!id) return;
    try {
      // await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
      setAssignments(assignments.filter(a => a.assignmentId !== id));
    } catch (error) {
      console.error('Failed to unassign', error);
    }
  };

  return (
    <div className="license-assignment">
      <h2>License Assignment</h2>
      <p>Assign and manage software licenses to users.</p>

      <form onSubmit={handleAssign} className="form">
        <div className="form-group">
          <label>License ID:</label>
          <input type="number" name="licenseId" value={form.licenseId} onChange={handleChange} required />
        </div>

        <div className="form-group">
          <label>Assignee:</label>
          <input type="text" name="assignee" value={form.assignee} onChange={handleChange} required />
        </div>

        <div className="form-group">
          <label>User Count:</label>
          <input type="number" name="userCount" value={form.userCount} onChange={handleChange} required min={1} />
        </div>

        <div className="form-group">
          <label>Assignment Date:</label>
          <input type="date" name="assignmentDate" value={form.assignmentDate} onChange={handleChange} required />
        </div>

        <div className="form-group">
          <label>Status:</label>
          <select name="status" value={form.status} onChange={handleChange}>
            <option value="Active">Active</option>
            <option value="Expired">Expired</option>
            <option value="Revoked">Revoked</option>
          </select>
        </div>

        <div className="form-group">
          <label>Email:</label>
          <input type="email" name="email" value={form.email} onChange={handleChange} required />
        </div>

        <button type="submit" className="assign-btn">Assign License</button>
      </form>

      <h3 className="table-heading">Assigned Licenses</h3>
      <table className="assignments-table">
        <thead>
          <tr>
            <th>Assignment ID</th>
            <th>License ID</th>
            <th>Assignee</th>
            <th>User Count</th>
            <th>Date</th>
            <th>Status</th>
            <th>Email</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {assignments.length > 0 ? (
            assignments.map((item) => (
              <tr key={item.assignmentId}>
                <td>{item.assignmentId}</td>
                <td>{item.licenseId}</td>
                <td>{item.assignee}</td>
                <td>{item.userCount}</td>
                <td>{item.assignmentDate}</td>
                <td>{item.status}</td>
                <td>{item.email}</td>
                <td>
                  <button className="unassign-btn" onClick={() => handleUnassign(item.assignmentId)}>
                    Unassign
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr><td colSpan={8} style={{ textAlign: 'center' }}>No assignments yet.</td></tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default LicenseAssignment;
