#include <iostream>
#include <memory>
#include <string>
template <typename T>
class MyArray
{
private:
    int currentIndex;
    int capacity;
    std::unique_ptr<T[]> data;

public:
    MyArray() : currentIndex(0), capacity(1)
    {
        data = std::make_unique<T[]>(capacity);
    }
    void push(T item)
    {
        if (currentIndex == capacity)
        {
            auto tempCopy = std::move(data); // copy prev content

            capacity *= 2;                          // double the capacity
            data = std::make_unique<T[]>(capacity); // get some brand new memory :)
            for (int i = 0; i < currentIndex; i++)
            {
                data[i] = tempCopy[i]; // copy the prev content back to our new memory, not so new now :(
            }
        }
        data[currentIndex++] = item;
    }

    T pop()
    {
        return data[currentIndex--]; // not really pop, just a dirty hack :)
    }
    T get(int index)
    {
        if (index < 0 || index >= currentIndex)
            return NULL; // again a hack, will throw exeption with std::string etc
        return data[index];
    }
    int length()
    {
        return currentIndex;
    }
};

// Example usage
int main()
{
    MyArray<int> myArray;
    myArray.push(1);
    myArray.push(3);
    myArray.push(5);
    std::cout << myArray.length() << std::endl;
    std::cout << myArray.get(2) << std::endl;
    myArray.pop();
    std::cout << myArray.get(2) << std::endl;
    std::cout << myArray.length() << std::endl;
}