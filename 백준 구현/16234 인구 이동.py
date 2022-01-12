import math

def get_Entropy(value,mynums):
    print(value,mynums)
    temp = 0
    for i in mynums:
        if i == 0 : continue
        temp = temp - i*math.log2(i)
        print(i*math.log2(i))
    print()
    return value*temp
t = get_Entropy(1,[9/14,5/14])
a = get_Entropy(5/14,[2/5,3/5])
b = get_Entropy(4/14,[4/4,0/4])
c = get_Entropy(5/14,[2/5,3/5])
print(" E  =   {0}   E_sub = {1}, {2}, {3}, total = {4}    answer_ = {5}".format( t, a, b , c,(a+b+c), t - (a+b+c) ))
SI = get_Entropy(1,[5/14,4/14,5/14])
IG = t - (a+b+c)
print("Split Info = {0}, Gain Ratio = {1}".format(SI, IG/SI))

print()
t = get_Entropy(1,[9/14,5/14])
a = get_Entropy(4/14,[2/4,2/4])
b = get_Entropy(6/14,[2/6,4/6])
c = get_Entropy(4/14,[3/4,1/4])
print(" E  =   {0}   E_sub = {1}, {2}, {3}, total = {4}    answer_ = {5}".format( t, a, b , c,(a+b+c), t - (a+b+c) ))
SI = get_Entropy(1,[4/14,6/14,4/14])
IG = t - (a+b+c)
print("Split Info = {0}, Gain Ratio = {1}".format(SI, IG/SI))

print()
t = get_Entropy(1,[9/14,5/14])
a = get_Entropy(7/14,[3/7,4/7])
b = get_Entropy(7/14,[6/7,1/7])
print(" E  =   {0}   E_sub = {1}, {2},  total = {3}   answer_ = {4}".format( t, a, b , (a+b), t - (a+b) ))
SI = get_Entropy(1,[7/14,7/14])
IG = t - (a+b)
print("Split Info = {0}, Gain Ratio = {1}".format(SI, IG/SI))


print()
t = get_Entropy(1,[9/14,5/14])
a = get_Entropy(6/14,[3/6,3/6])
b = get_Entropy(8/14,[6/8,2/8])
print(" E  =   {0}   E_sub = {1}, {2},  total = {3}   answer_ = {4}".format( t, a, b , (a+b), t - (a+b) ))
SI = get_Entropy(1,[6/14,8/14])
IG = t - (a+b)
print("Split Info = {0}, Gain Ratio = {1}".format(SI, IG/SI))