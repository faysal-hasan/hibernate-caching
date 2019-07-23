package mfh.learn.hib.model;

import mfh.learn.hib.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.lang.reflect.Method;

@Slf4j
public class CustomIdGenerator implements IdentifierGenerator {

    public static String generateGlobalId() {
        long currentTimeMillis = System.currentTimeMillis();
        String idString = String.valueOf(currentTimeMillis);
        System.out.println("ID: " + idString);
        log.info("ID: " + idString);
        int length = idString.length();
        if (length > 8) {
            return idString.substring(length - 8);
        } else {
            throw new ApiException("Error in ID creation!");
        }
    }

    public static void main(String arg[]) {
        String generateGlobalId = generateGlobalId();
        System.out.println(generateGlobalId);
    }

    public String generate() {
        return generateGlobalId();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Class<? extends Object> clazz = object.getClass();
        Serializable generatedId = null;
        try {
            Method method = clazz.getMethod("getId", (Class<?>[]) null);
            if (method != null) {
                Object id = method.invoke(object, (Object[]) null);
                if (id != null) {
                    generatedId = (Serializable) id;
                }
            }

        } catch (Exception e) {
        }
        if (generatedId == null) {
            generatedId = generate();
        }
        return generatedId;

    }
}
