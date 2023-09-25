package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.StudentLoan;
import org.example.repository.StudentLoanRepository;

import java.util.List;

public class StudentLoanRepositoryImpl extends BaseRepository implements StudentLoanRepository {

    @Override
    public void saveStudentLoan(StudentLoan studentLoan) {
        em.getTransaction().begin();
        em.persist(studentLoan);
        em.getTransaction().commit();
    }

    @Override
    public StudentLoan getStudentLoanById(Long id) {
        StudentLoan studentLoan = em.find(StudentLoan.class, id);
        return studentLoan;
    }

    @Override
    public List<StudentLoan> getAllStudentLoan() {
        List<StudentLoan> studentLoans =
                em.createQuery("SELECT s FROM StudentLoan s", StudentLoan.class).getResultList();
        return studentLoans;
    }

    @Override
    public void updateStudentLoan(StudentLoan studentLoan) {
        em.getTransaction().begin();
        em.merge(studentLoan);
        em.getTransaction().commit();
    }

    @Override
    public void deleteStudentLoan(StudentLoan studentLoan) {
        em.getTransaction().begin();
        em.remove(em.contains(studentLoan) ? studentLoan : em.merge(studentLoan));
        em.getTransaction().commit();
    }

}


