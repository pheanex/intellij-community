class ConstructorExists {
  void foo(Object o, Class<?> c) throws Exception {
    Class ca = A.class;

    ca.getConstructor(int.class);
    ca.getConstructor<warning descr="Constructor is not public">(float.class)</warning>;
    ca.getConstructor<warning descr="Constructor is not public">(boolean.class)</warning>;
    ca.getConstructor<warning descr="Constructor is not public">(String.class)</warning>;
    ca.getConstructor<warning descr="Cannot resolve constructor with specified argument types">(Exception.class)</warning>;

    ca.getConstructor(int.class, boolean.class, String.class);
    ca.getConstructor(int.class, c, String.class);
    ca.getConstructor<warning descr="Cannot resolve constructor with specified argument types">(int.class, o.getClass(), String.class)</warning>;

    ca.getDeclaredConstructor(int.class);
    ca.getDeclaredConstructor(float.class);
    ca.getDeclaredConstructor(boolean.class);
    ca.getDeclaredConstructor(String.class);
    ca.getDeclaredConstructor<warning descr="Cannot resolve constructor with specified argument types">(Exception.class)</warning>;

    ca.getDeclaredConstructor(int.class, boolean.class, String.class);
    ca.getDeclaredConstructor(int.class, c, String.class);
    ca.getDeclaredConstructor<warning descr="Cannot resolve constructor with specified argument types">(int.class, o.getClass(), String.class)</warning>;

    C.class.getConstructor(int.class);
    C.class.getConstructor<warning descr="Cannot resolve constructor with specified argument types">(boolean.class)</warning>;
  }

  static class A {
    public A(int n) {}
    protected A(float f) {}
    A(boolean b) {}
    private A(String s) {}

    public A(int n, boolean b, String s) {}
    public A(int n, boolean b, float f) {}
  }

  static final class C extends A {
    public C(int n) { super(n); }
  }
}