if RK-M
    gross pay
    if lumper fee
        add fee
    else
        add 0
    if dispatched
        subtract 5%
    else
        subtract 0
    display sum
   
if RK-D
    gross pay
    if lumper fee
        add fee
    else
        add 0
    if dispatched
        subtract 5%
    else
        subtract 0
    if factored
        subtract 1%
    else
        subtract 0
    display sum
    
need running tally of - 
    Dispatch Pay
    OTB Net Pay
    RK Net Pay