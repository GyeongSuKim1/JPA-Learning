package org.example.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
        Member member = new Member();
        member.setId(2L);
        member.setName("1st 맴버");

        // 저장
        em.persist(member);

        tx.commit();

/*
        // 조회
        Member findMember = em.find(Member.class, 1L);

        // 수정
        findMember.setName("2st 맴버");

        // 삭제
        em.remove(findMember);
*/
        } catch (Exception e) {
            tx.rollback();
        } finally {
        em.close();
        }

        emf.close();
    }
}
