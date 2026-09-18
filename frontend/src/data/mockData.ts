export interface Project {
  id: string;
  title: string;
  abstract: string;
  technologies: string[];
  githubLink?: string;
  status: 'approved' | 'pending' | 'rejected';
  submittedBy: string;
  submittedById?: string;
  submittedAt: string;
  rejectionComment?: string;
  type: 'portfolio' | 'abstract';
}

export interface User {
  id: string;
  email: string;
  name: string;
  role: 'STUDENT' | 'STAFF';
  department: string;
}
