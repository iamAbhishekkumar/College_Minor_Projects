pass1 = input("Enter 1st pin :")
pass2 = input("Enter 2nd pin :")
pass3 = input("Enter 3rd pin :")
pass4 = input("Enter 4th pin :")
msg = input("Enter your message : ").upper().replace(" ", "")

pin = ""
for i in range(6):
    pin += str(min(int(pass1[i]), int(pass2[i]), int(pass3[i]), int(pass4[i])))
dictionary = {"Z": 0, 0: "Z"}
alpha = "A"
for i in range(1, 26):
    dictionary[i] = alpha
    dictionary[alpha] = i
    alpha = chr(ord(alpha) + 1)
if len(msg) % len(pin) == 0:
    turns = len(msg) / len(pin)
else:
    turns = (len(msg) / len(pin)) + 1

new_msg = ""
k = 0
for i in range(int(turns)):
    for j in range(len(pin)):
        if k < len(msg):
            num = (dictionary[msg[k]] + int(pin[j])) % 26
            new_msg += dictionary[num]
            k += 1
print(f'The encrypted message is : {new_msg}')

