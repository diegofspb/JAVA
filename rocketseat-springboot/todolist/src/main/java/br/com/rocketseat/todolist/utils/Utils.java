package br.com.rocketseat.todolist.utils;
// a ideia é que esta classe possa filtrar a entrada de dados quando se criar uma nova tarefa, desta forma o método abaixo pode ser reaproveitado

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

    public static void copyNonNullProperties(Object source, Object target){
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    // pegando as propriedades do objeto e verificando se o nome é nulo

    public static String[] getNullPropertyNames(Object source){
        final BeanWrapper src = new BeanWrapperImpl(source);

        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();

        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];  // cria-se um array de String com nome result com o tamanho dos 'nomes vazios'

        return emptyNames.toArray(result);

    }
    
}
