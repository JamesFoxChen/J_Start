import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2015/5/6.
 */
public class PropertiesUtil {

    //�����ļ���·��
    private String configPath = null;

    /**
     * �����ļ�����
     */
    private Properties props = null;

    /**
     * Ĭ�Ϲ��캯��������sh���У��Զ��ҵ�classpath�µ�config.properties��
     */
    public PropertiesUtil() throws IOException {
        this.configPath="config.properties";

        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
        props = new Properties();
        props.load(in);
        //�ر���Դ
        in.close();
    }

    /**
     * ����keyֵ��ȡ���õ�ֵ
     */
    public String readValue(String key) throws IOException {
        return props.getProperty(key);
    }

    /**
     * ��ȡproperties��ȫ����Ϣ
     *
     * @throws FileNotFoundException �����ļ�û���ҵ�
     * @throws IOException           �ر���Դ�ļ������߼��������ļ�����
     */

    public Map<String, String> readAllProperties() throws FileNotFoundException, IOException {
        //�������еļ�ֵ
        Map<String, String> map = new HashMap<String, String>();
        Enumeration en = props.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            String Property = props.getProperty(key);
            map.put(key, Property);
        }
        return map;
    }

    public void updateValue(String key,String value) {
        try {
            props.load(new FileInputStream(this.configPath));
            // ���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ�����ԡ�
            // ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����
            OutputStream fos = new FileOutputStream(this.configPath);
            props.setProperty(key, value);
            // ���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ��
            // ���� Properties ���е������б�����Ԫ�ضԣ�д�������
            props.store(fos, "Update '" + key + "' value");
        } catch (IOException e) {
            System.err.println("�����ļ����´���");
        }
    }

    /**
     * ����ĳ��key��ֵ,���������ļ���
     *
     * @param key keyֵ
     * @return key ����Ӧ��ֵ
     * @throws IOException
     */
    public void setValue(String key, String value) throws IOException {

            // ���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ�����ԡ�
            // ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����
            OutputStream fos = new FileOutputStream(this.configPath);
            props.setProperty(key, value);
            // ���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ��
            // ���� Properties ���е������б�����Ԫ�ضԣ�д�������
            props.store(fos, "Update '" + value + "' value");

//        //props.setProperty(key,value);
//        Properties prop = new Properties();
//        InputStream fis = new FileInputStream(this.configPath);
//        // ���������ж�ȡ�����б�����Ԫ�ضԣ�
//        prop.load(fis);
//        // ���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ�����ԡ�
//        // ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����
//        OutputStream fos = new FileOutputStream(this.configPath);
//        prop.setProperty(key, value);
//        // ���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ��
//        // ���� Properties ���е������б�����Ԫ�ضԣ�д�������
//        prop.store(fos, "last update");
//        //�ر��ļ�
//        fis.close();
//        fos.close();
    }
}
