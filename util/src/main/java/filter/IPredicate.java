package filter;

public interface IPredicate<T> {
	boolean apply(T type);
}