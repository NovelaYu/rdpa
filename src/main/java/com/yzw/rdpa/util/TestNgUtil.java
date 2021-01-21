package com.yzw.rdpa.util;


// todo
public class TestNgUtil {
    /**
     * 生成testng.xml
     * @return
     */
 /*  public Boolean createTestNGXML() {
        String prefix = "Test";
        String classesDir = "./test/resources/";
        XmlSuite suite = new XmlSuite();
        XmlTest xmlTest = new XmlTest(suite);
        List<XmlClass> xmlClasses = new ArrayList<>();

        // testng.xml全名
        suite.setFileName(prefix + "_testng.xml");
        // 不设置这个suite.toXml()会报NPT
        suite.setJunit(false);
        suite.setName(prefix);
        xmlTest.setName(prefix);

        try {
            // 新建classloader实例
            URLClassLoader loader = URLClassLoader.newInstance(new URL[] {}, getClass().getClassLoader());
            // 测试用例class所在目录加到classloader的classpath中
            TestNGUtil.addPath(loader, new File(classesDir).toURI().toURL());

            // 循环遍历所有的class文件
            Collection<File> classFiles = FileUtils.listFiles(new File(classesDir), new WildcardFileFilter("*.class"),
                    TrueFileFilter.INSTANCE);
            for (File f : classFiles) {
                // 包含$说明为内部类
                if (f.getName().contains("$")) {
                    continue;
                }
                XmlClass xmlClass = new XmlClass();
                List<XmlInclude> includes = new ArrayList<>();

                // 只要class名称不要后缀
                String clazzName = f.getName().replace(".class", "");
                xmlClass.setName(clazzName);

                Class<?> clazz = Class.forName(clazzName, false, loader);
                // 遍历所有方法，找到包含@Test标注的方法
                for (Method m : clazz.getMethods()) {
                    if (hasTestAnnotation(m)) {
                        XmlInclude xmlInclude = new XmlInclude(m.getName());
                        includes.add(xmlInclude);
                    }
                }
                xmlClass.setIncludedMethods(includes);
                xmlClasses.add(xmlClass);
            }

            xmlTest.setXmlClasses(xmlClasses);

            // 保存到文件系统中
            FileUtils.write(new File(classesDir + "/" + suite.getFileName()), suite.toXml(), Charset.defaultCharset());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Boolean hasTestAnnotation(Method m) {
        List<Annotation> annotations = Arrays.asList(m.getAnnotations());
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().getName().equals(Test.class.getName())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;*/
    }
